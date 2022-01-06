 /**
 * Programmer: Fernando Pires Rui
 * Date: 18/06/2021
 * Name: Sorting Routines
 * This program will use the 4 types of sorting (selection, Bubble, insertion and quick) to sort randoms numbers ascending or descending.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SourtingRoutines extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup SortGroup = new ButtonGroup();
	private JTextField Input;
	private final ButtonGroup DisplayGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SourtingRoutines frame = new SourtingRoutines();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SourtingRoutines() {
		
		//Creating a Random object
		Random generator = new Random();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sorting Routines");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(151, 11, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the following information:");
		lblNewLabel_1.setBounds(10, 36, 225, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sorting Algorithm:");
		lblNewLabel_2.setBounds(20, 61, 126, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sort Order");
		lblNewLabel_3.setBounds(261, 61, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount of Numbers to Sort:");
		lblNewLabel_4.setBounds(25, 203, 178, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Original Numbers");
		lblNewLabel_5.setBounds(25, 250, 121, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sorted Numbers");
		lblNewLabel_6.setBounds(282, 250, 95, 14);
		contentPane.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 291, 194, 127);
		contentPane.add(scrollPane);
		
		JTextArea ONumbers = new JTextArea();
		ONumbers.setEditable(false);
		ONumbers.setBackground(Color.WHITE);
		scrollPane.setViewportView(ONumbers);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(282, 291, 193, 127);
		contentPane.add(scrollPane_1);
		
		JTextArea SNumbers = new JTextArea();
		SNumbers.setBackground(Color.WHITE);
		SNumbers.setEditable(false);
		scrollPane_1.setViewportView(SNumbers);
		
		Input = new JTextField();
		Input.setBackground(Color.WHITE);
		Input.setBounds(213, 200, 52, 20);
		contentPane.add(Input);
		Input.setColumns(10);
		
		JRadioButton SelectionBtn = new JRadioButton("Selection");
		SortGroup.add(SelectionBtn);
		SelectionBtn.setBounds(147, 57, 88, 23);
		contentPane.add(SelectionBtn);
		
		JRadioButton BubbleBtn = new JRadioButton("Bubble");
		SortGroup.add(BubbleBtn);
		BubbleBtn.setBounds(147, 82, 109, 29);
		contentPane.add(BubbleBtn);
		
		JRadioButton InsertionBtn = new JRadioButton("Insertion");
		SortGroup.add(InsertionBtn);
		InsertionBtn.setBounds(147, 114, 109, 23);
		contentPane.add(InsertionBtn);
		
		JRadioButton QuickBtn = new JRadioButton("Quick");
		SortGroup.add(QuickBtn);
		QuickBtn.setBounds(147, 142, 109, 23);
		contentPane.add(QuickBtn);
		
		JRadioButton AscendingBtn = new JRadioButton("Ascending");
		DisplayGroup.add(AscendingBtn);
		AscendingBtn.setBounds(336, 57, 109, 23);
		contentPane.add(AscendingBtn);
		
		JRadioButton DescendingBtn = new JRadioButton("Descending");
		DisplayGroup.add(DescendingBtn);
		DescendingBtn.setBounds(336, 85, 109, 23);
		contentPane.add(DescendingBtn);
		
		
		JButton SortBtn = new JButton("Sort Numbers");
		SortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Clearing the textAreas each time this button is pushed
				SNumbers.setText(null);
				ONumbers.setText(null);
				
				// Creating a local variable to store the user input
				int num = 0;
			
				
				// Handling NumberFormatException
				try {
					num = Integer.parseInt(Input.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "the answer must be a integer");
				}
				
				// Creating an ArrayList to store the random numbers
				int list[] = new int[num ]; 
				
				// Generating the random numbers and storing it on the array
				for (int c = 0; c < num; c++) {
					list[c] =  generator.nextInt(1000 + 1000)-1000;
					ONumbers.append(Integer.toString(list[c]) + "\n");
				}
				
				// Selection sort in ascending order
				if (SelectionBtn.isSelected() && AscendingBtn.isSelected()) {
					selection(list);
					for (int c = 0; c < num;c++) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				// Quick sort in ascending order
				if (QuickBtn.isSelected() && AscendingBtn.isSelected()) {
					quick(list, 0, list.length - 1);
					for (int c = 0; c < list.length; c++) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				
				// Insetion sort in ascending order
				if (InsertionBtn.isSelected() && AscendingBtn.isSelected()) {
					insertion(list);
					for (int c = 0; c < num; c++) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				
				// Bubble sort in ascending order
				if (BubbleBtn.isSelected() && AscendingBtn.isSelected()) {
					bubble(list);
					for (int c = 0; c < num; c++) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				
				// Selection sort in descending order
				if (SelectionBtn.isSelected() && DescendingBtn.isSelected()) {
					selection(list);
					for (int c = list.length - 1; c >= 0; c--) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				
				// Quick sort in descending order
				if (QuickBtn.isSelected() && DescendingBtn.isSelected()) {
					quick(list, 0, list.length - 1);
					for (int c = num - 1;  c >= 0; c--) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				
				// Insertion sort in descending order
				if (InsertionBtn.isSelected() && DescendingBtn.isSelected()) {
					insertion(list);
					for (int c = num - 1; c >= 0; c--) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
				
				// Bubble sort in ascending order
				if (BubbleBtn.isSelected() && DescendingBtn.isSelected()) {
					bubble(list);
					for (int c = num - 1; c >= 0; c--) {
						SNumbers.append(Integer.toString(list[c]) + "\n");
					}
				}
			}
		});
		SortBtn.setBounds(327, 194, 118, 23);
		contentPane.add(SortBtn);
	
	}
	
	// Selection sort
	//https://www.geeksforgeeks.org/selection-sort/
	public void selection(int []list){
        int n = list.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (list[j] < list[min_idx]) {
                    min_idx = j;
                }
            // Swap the found minimum element with the first
            // element
            swap(list,min_idx,i);
        }
    }
	// Bubble Sort
	//https://www.geeksforgeeks.org/bubble-sort/
	public void bubble (int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if ( arr[j] > arr[ j + 1]) {
					swap(arr, j, j + 1);
				}
			}
			
		}
	}
	
	// Insertion Sort
	//https://www.geeksforgeeks.org/insertion-sort/
	public void insertion(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int  j = i - 1;
					
			while( j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[ j + 1] = key;
		}	
	}
	// Quick Sort
	//https://howtodoinjava.com/algorithm/quicksort-java-example/
	public static void quick(int [] arr, int low, int high) 
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }
         
        if (low >= high){
            return;
        }
 
        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
 
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) 
        {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) 
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot) 
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (i <= j) 
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quick(arr, low, j);
        }
        if (high > i){
            quick(arr, i, high);
        }
    }
		

	// TODO Auto-generated method stub
	public static void swap (int array[], int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
