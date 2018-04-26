package Apa;

import java.util.PriorityQueue;

public class FilaDePrioridades {
	private PriorityQueue<Aresta> queue;
	
	public FilaDePrioridades() {
		queue = new PriorityQueue<Aresta>((Aresta o1, Aresta o2) -> {
			return o1.compareTo(o2);
		});
	}

	public void add(Aresta e) {
		queue.add(e);
	}

	public boolean estaVazio() {
		return queue.isEmpty();
	}

	public Aresta peek() {
		return queue.peek();
	}

	public Aresta poll() {
		return queue.poll();
	}
}
