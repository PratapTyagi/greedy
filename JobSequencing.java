import java.util.*;
import java.io.*;

class Job {
	int jobId;
	int deadline;
	int profit;

	public Job(int j, int d, int p) {
		jobId = j;
		deadline = d;
		profit = p;
	}
}

public class JobSequencing {

	static void sequencing(Job[] job, int n) {
		if(job == null) return;
		Arrays.sort(job, (a, b) -> b.profit - a.profit);

		boolean[] taken = new boolean[n];
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=Math.min(n, job[i].deadline-1); j>=0; j--) {
				if(taken[j] == false) {
					ans += job[i].profit;
					taken[j] = true;
					break;
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());	
		Job[] job = new Job[n];

		System.out.println("Enter "+n+" no. of jobs");
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split("\\s+");
			int id = Integer.parseInt(s[0]);
			int deadline = Integer.parseInt(s[1]);	
			int profit = Integer.parseInt(s[2]);
			job[i] = new Job(id, deadline, profit);			
		}

		sequencing(job, n);		
	}

}