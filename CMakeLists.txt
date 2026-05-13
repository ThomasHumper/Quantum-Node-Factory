# Compiler
CC = gcc

# Compiler flags
CFLAGS = -Wall -Wextra -std=c11

# Output executable
TARGET = quantum_node

# Source files
SRC = Enterprise/*.java

# Build target
all:
	$(CC) $(CFLAGS) $(SRC) -o $(TARGET)

# Run program
run: all
	./$(TARGET)

# Clean build files
clean:
	rm -f $(TARGET)
