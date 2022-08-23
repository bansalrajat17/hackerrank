import java.util.ArrayList;
import java.util.List;

// Implement the Stack class
class Stack {
	List<Integer> A;
	int capacity = 0;
	int top = -1;
	public Stack (int capacity) {
		this.capacity = capacity;
		this.A = new ArrayList<>(capacity);
	}

	public boolean isEmpty() {
		if(this.top == -1)
			return true;
		else return false;
	}
	
	public int size() {
		return this.A.size();
	}
	
	public int top() {
		if(this.top == -1)
		{
			return top;
		}
		else
			return this.A.get(this.top);
	}
	
	public void push(int element) {
		if((this.capacity > 0) && this.top < (this.capacity - 1))
		{
			this.top++;
			this.A.add(this.top,element);
		}
		else
		{
			System.out.println("Stack Overflow");
		}
	}
	
	public void pop() {
		if(!this.isEmpty())
		{
			this.A.remove(this.top);
			this.top--;
		}
		else
		{
			System.out.println("Stack Underflow");
		}
	}
}