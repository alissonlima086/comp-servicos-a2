package main

import (
	"log"
	"net"

	"google.golang.org/grpc"

	"grpc-server/internal"
	"grpc-server/proto"
)

func main() {
	listener, err := net.Listen("tcp", ":50051")
	if err != nil {
		log.Fatalf("Erro ao ouvir na porta 50051: %v", err)
	}

	grpcServer := grpc.NewServer()

	emailServer := &internal.EmailServer{}

	proto.RegisterEmailServiceServer(grpcServer, emailServer)

	log.Println("Servidor gRPC rodando na porta 50051...")
	if err := grpcServer.Serve(listener); err != nil {
		log.Fatalf("Falha ao iniciar servidor gRPC: %v", err)
	}
}
