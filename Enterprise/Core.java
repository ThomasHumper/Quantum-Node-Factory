; boot.asm - 16-bit boot sector

org 0x7C00          ; BIOS loads boot sector here

start:
    mov si, message ; point to message

print:
    lodsb           ; load byte from SI into AL
    cmp al, 0
    je hang         ; if end of string, stop

    mov ah, 0x0E    ; BIOS teletype output
    int 0x10        ; print character in AL
    jmp print

hang:
    jmp hang        ; infinite loop (halt)

message db "Hello from my tiny OS!", 0

times 510-($-$$) db 0 ; pad to 512 bytes
dw 0xAA55            ; boot signature
  #include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <cstdlib>

std::vector<std::string> split(const std::string& input) {
    std::vector<std::string> tokens;
    std::stringstream ss(input);
    std::string token;

    while (ss >> token) {
        tokens.push_back(token);
    }

    return tokens;
}

void execute(const std::vector<std::string>& args) {
    if (args.empty()) return;

    const std::string& cmd = args[0];

    if (cmd == "exit") {
        std::cout << "Exiting shell...\n";
        std::exit(0);
    }
    else if (cmd == "echo") {
        for (size_t i = 1; i < args.size(); i++) {
            std::cout << args[i] << " ";
        }
        std::cout << "\n";
    }
    else if (cmd == "help") {
        std::cout << "Commands:\n";
        std::cout << "  echo [text] - print text\n";
        std::cout << "  help        - show commands\n";
        std::cout << "  exit        - quit shell\n";
    }
    else {
        std::cout << "Unknown command: " << cmd << "\n";
    }
}

int main() {
    std::string input;

    std::cout << "Simple C++ Shell. Type 'help' for commands.\n";

    while (true) {
        std::cout << "shell> ";
        std::getline(std::cin, input);

        std::vector<std::string> args = split(input);
        execute(args);
    }

    return 0;
}
