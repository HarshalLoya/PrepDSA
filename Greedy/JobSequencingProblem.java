
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobSequencingProblem {

    static class Job {

        char id;
        int deadline, profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

    }

    static List<Job> scheduler(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slots = new boolean[maxDeadline + 1];
        List<Job> scheduledJobs = new ArrayList<>();

        for (Job job : jobs) {
            for (int t = job.deadline; t > 0; t--) {
                if (!slots[t]) {
                    slots[t] = true;
                    scheduledJobs.add(job);
                    break;
                }
            }
        }

        return scheduledJobs;
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 5, 25),
            new Job('e', 3, 15)
        };

        List<Job> schedule = scheduler(jobs);
        int profit = 0;
        for (Job job : schedule) {
            profit += job.profit;
        }

        for (Job job : schedule) {
            System.out.print(job.id + "  ");
        }
        System.out.println("\nTotal Profit: " + profit);

    }
}
