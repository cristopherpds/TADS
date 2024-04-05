import socket

# Cria um socket TCP/IP
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Define o endereço e a porta em que o servidor irá escutar
server_address = ('localhost', 8888)
print(f"Iniciando servidor em {server_address[0]} porta {server_address[1]}")
server_socket.bind(server_address)

# Espera por conexões
server_socket.listen(1)

while True:
    # Aguarda por uma conexão
    print("Aguardando por uma conexão...")
    connection, client_address = server_socket.accept()

    try:
        print(f"Conexão de {client_address}")
        
        # Recebe os dados do cliente e os imprime
        while True:
            data = connection.recv(1024)
            if data:
                print(f"Dados recebidos: {data.decode()}")
            else:
                print("Não há mais dados do cliente")
                break
                
    finally:
        # Fecha a conexão
        connection.close()
