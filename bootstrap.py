import time
import random
from collections import defaultdict


class EventBus:
    def __init__(self):
        self.subscribers = defaultdict(list)

    def subscribe(self, event_type, handler):
        self.subscribers[event_type].append(handler)
        print(f"[+] Subscribed to event: {event_type}")

    def publish(self, event_type, data):
        print(f"\n[EVENT] {event_type}")
        print(f"Payload: {data}")

        if event_type in self.subscribers:
            for handler in self.subscribers[event_type]:
                handler(data)
        else:
            print("[!] No subscribers for this event.")


# -----------------------------------
# Quantum Node Event Handlers
# -----------------------------------

def quantum_node_handler(data):
    print(
        f"[Quantum Node] Node {data['node_id']} "
        f"probability updated to {data['probability']:.4f}"
    )


def blockchain_agent_handler(data):
    print(
        f"[Blockchain Agent] Agent sync completed "
        f"for node {data['node_id']}"
    )


def anomaly_detector(data):
    if data["probability"] < 0.30:
        print(
            f"[ALERT] Quantum instability detected "
            f"on node {data['node_id']}"
        )


# -----------------------------------
# Quantum Event Simulation
# -----------------------------------

def generate_quantum_event(node_id):
    probability = random.uniform(0.0, 1.0)

    return {
        "node_id": node_id,
        "probability": probability,
        "timestamp": time.time()
    }


# -----------------------------------
# Main Simulation
# -----------------------------------

def main():
    event_bus = EventBus()

    # Register handlers
    event_bus.subscribe("QUANTUM_UPDATE", quantum_node_handler)
    event_bus.subscribe("QUANTUM_UPDATE", anomaly_detector)
    event_bus.subscribe("BLOCKCHAIN_SYNC", blockchain_agent_handler)

    quantum_nodes = [101, 202, 303, 404]

    print("\n=== Quantum Event Bus Simulation Started ===")

    for _ in range(10):
        node_id = random.choice(quantum_nodes)

        event_data = generate_quantum_event(node_id)

        # Publish quantum update event
        event_bus.publish("QUANTUM_UPDATE", event_data)

        # Simulate blockchain synchronization
        if random.random() > 0.5:
            event_bus.publish("BLOCKCHAIN_SYNC", event_data)

        time.sleep(1)

    print("\n=== Simulation Complete ===")


if __name__ == "__main__":
    main()
