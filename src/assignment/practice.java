package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class practice {
	public void isTwice(int[] input){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < input.length; i++){
			if(map.containsKey(input[i])){
				map.put(input[i], map.get(input[i]) + 1);
			}
			else{
				map.put(input[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() == 2){
				System.out.print(entry.getKey() + " ");
			}
		}
		System.out.println();
	}
	public void twoSum(int[] input, int sum){
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < input.length; i++){
			int target = sum - input[i];
			if(!set.contains(target)){
				set.add(input[i]);
			}
			else{
				System.out.println("< " + input[i] + " , " + target + " >");
			}
		}
	}
	public void levelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < size; i++){
				if(queue.peek().left != null){
					queue.add(queue.peek().left);
				}
				if(queue.peek().right != null){
					queue.add(queue.peek().right);
				}
				list.add(queue.poll().val);
			}
			System.out.println(list.toString());
			}
		}
	public void reverseBST(TreeNode root){
		List<Integer> reverseOrder = new ArrayList<Integer>();
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pollFirst();
			if(temp.right != null){
				stack.offerFirst(temp.right);
			}
			if(temp.left != null){
				stack.offerFirst(temp.left);
			}
			reverseOrder.add(temp.val);
		}
		Collections.reverse(reverseOrder);
		System.out.println(reverseOrder.toString());
	}
	public void permutations(String input){
		helper("", input);
	}
	private void helper(String pre, String input){
		if(input.length() == 0 && isforward(pre)){
			System.out.println(pre);
		}
		else{
			for(int i = 0; i < input.length(); i++){
				boolean flag = false;
				for(int j = 0; j < i; j++){
					if(input.charAt(j) == input.charAt(i))
						flag = true;
				}
				if(flag)
					continue;
				helper(pre + input.charAt(i),input.substring(0, i) + input.substring(i+1, input.length()));
			}
		}
	}
	private boolean isforward(String input){
		for(int i = 0; i < input.length() - 1; i++){
			if(input.charAt(i + 1) < input.charAt(i)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		practice p = new practice();
		int[] array = new int[]{1,6,3,4,3,9,7,2,5,6,8};
		int[] array1 = new int[]{1,2,7,8,9};
		p.isTwice(array);
		p.twoSum(array1, 9);
		String input = "acbd";
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		node.left = node1;
		node.right = node2;
		p.levelOrder(node);
		p.reverseBST(node);
		p.permutations(input);
	}
	
}
class TreeNode{
	int val;
    TreeNode left;
    TreeNode right;
	TreeNode(int x) 
	{ val = x; }
}
