package stackQueue;

// Creating stack with the help of an array
public class ArrayStack<T> {

     public Object[] arr;
     public int top, size;

     /*  Constructor for arrayStack */
     public ArrayStack(int n) {
         size = 0;
         arr = new Object[n];
         top = -1;
     }
     /* Function to check if stack is empty */
     public boolean isEmpty() {
         return top == -1;
     }
     /* Function to check if stack is full */
     public boolean isFull() {
         return top == size -1 ;
     }
     /* Function to get the size of the stack */
     public int getSize() {
         return size;
     }
     /* Function to check the top element of the stack */
     public Object peek() {
         if (isEmpty()) {
             System.out.println("Stack is empty");
         }
         return arr[top];
     }
     /* Function to add an element to the stack */
     public void push(Object data) {
         if (isFull()) {
             System.out.println("Stack is full");
         } else {
             arr[++top] = data;
             size++ ;
         }
     }
     /*  Function to delete an element from the stack */
     public Object pop() {
         Object popedElement = null;
         if (isEmpty()) {
             System.out.println("Stack is empty"); 
         } else {
             popedElement = arr[top];
             top--; // Going downwards
             size--;
         }
         return popedElement; 
     }
     /*  Function to display the status of the stack */
     public void display() {
         System.out.print("\nStack = ");
         if (size == 0) {
             System.out.print("Empty\n");
             return ;
         }
         for (int i = top; i >= 0; i--)
              System.out.print(arr[i]+" ");
              System.out.println();
        }

    public static void main(String[] args) {
    }
}
