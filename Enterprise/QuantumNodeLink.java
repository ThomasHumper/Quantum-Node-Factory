#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

/*
    Quantum Node Linked List
    ------------------------
    Each node represents a "quantum node"
    with:
      - node id
      - probability state
      - entanglement label
      - next pointer
*/

typedef struct QuantumNode {
    int id;
    double probability;
    char entanglement[50];

    struct QuantumNode* next;
} QuantumNode;


/* Create a new quantum node */
QuantumNode* createNode(int id, double probability, const char* entanglement) {
    QuantumNode* newNode = (QuantumNode*)malloc(sizeof(QuantumNode));

    if (newNode == NULL) {
        printf("Memory allocation failed.\n");
        exit(1);
    }

    newNode->id = id;
    newNode->probability = probability;

    strcpy(newNode->entanglement, entanglement);

    newNode->next = NULL;

    return newNode;
}


/* Insert node at end */
void insertNode(QuantumNode** head, int id, double probability, const char* entanglement) {
    QuantumNode* newNode = createNode(id, probability, entanglement);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    QuantumNode* temp = *head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}


/* Display the linked list */
void displayNodes(QuantumNode* head) {
    QuantumNode* temp = head;

    printf("\n=== Quantum Node Chain ===\n");

    while (temp != NULL) {
        printf("Node ID        : %d\n", temp->id);
        printf("Probability    : %.4f\n", temp->probability);
        printf("Entanglement   : %s\n", temp->entanglement);
        printf("-----------------------------\n");

        temp = temp->next;
    }
}


/* Simulate quantum fluctuation */
void fluctuateProbabilities(QuantumNode* head) {
    QuantumNode* temp = head;

    srand((unsigned int)time(NULL));

    while (temp != NULL) {
        double fluctuation = ((double)rand() / RAND_MAX) * 0.2 - 0.1;

        temp->probability += fluctuation;

        if (temp->probability > 1.0)
            temp->probability = 1.0;

        if (temp->probability < 0.0)
            temp->probability = 0.0;

        temp = temp->next;
    }
}


/* Free memory */
void freeList(QuantumNode* head) {
    QuantumNode* temp;

    while (head != NULL) {
        temp = head;
        head = head->next;
        free(temp);
    }
}


int main() {
    QuantumNode* quantumChain = NULL;

    insertNode(&quantumChain, 101, 0.87, "Alpha-Link");
    insertNode(&quantumChain, 202, 0.63, "Beta-Entanglement");
    insertNode(&quantumChain, 303, 0.91, "Gamma-Field");

    printf("Initial Quantum Network:\n");
    displayNodes(quantumChain);

    printf("\nApplying quantum fluctuations...\n");

    fluctuateProbabilities(quantumChain);

    printf("\nUpdated Quantum Network:\n");
    displayNodes(quantumChain);

    freeList(quantumChain);

    return 0;
}
