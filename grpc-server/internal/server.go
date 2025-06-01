package internal

import (
	"context"
	"log"
	"sync"

	"grpc-server/proto"
)

type EmailServer struct {
	proto.UnimplementedEmailServiceServer
	emailList []string
	mu        sync.Mutex
}

// Adiciona email na memória
func (s *EmailServer) AddEmail(ctx context.Context, req *proto.EmailRequest) (*proto.EmailResponse, error) {
	email := req.GetEmail()

	s.mu.Lock()
	defer s.mu.Unlock()

	// Verifica se já existe
	for _, e := range s.emailList {
		if e == email {
			return &proto.EmailResponse{
				Message: "Email já cadastrado",
				Success: false,
			}, nil
		}
	}

	// Adiciona email na lista
	s.emailList = append(s.emailList, email)

	log.Printf("Email adicionado: %s", email)

	return &proto.EmailResponse{
		Message: "Email cadastrado com sucesso:",
		Success: true,
	}, nil
}

// Retorna emails
func (s *EmailServer) ListEmails(ctx context.Context, _ *proto.Empty) (*proto.EmailListResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	return &proto.EmailListResponse{
		Emails: s.emailList,
	}, nil
}