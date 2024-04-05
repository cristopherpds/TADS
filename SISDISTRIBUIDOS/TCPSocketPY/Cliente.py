import socket

# Cria um socket TCP/IP
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Define o endereço e a porta do servidor
server_address = ('localhost', 8888)
print(f"Conectando em {server_address[0]} porta {server_address[1]}")
client_socket.connect(server_address)

try:
    # Envia dados para o servidor
    message = "Olá, servidor!"
    print(f"Enviando: {message}")
    client_socket.sendall(message.encode())

    # Aguarda pela resposta do servidor
    data = client_socket.recv(1024)
    print(f"Recebido: {data.decode()}")

finally:
    # Fecha o socket
    client_socket.close()
