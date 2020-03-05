// https://leetcode.com/problems/rank-teams-by-votes/
// algorithms
// Medium (50.3%)
// Total Accepted: 5,444
// Total Submissions: 10,822
// beats 100.0% of java submissions


class Solution {
    public String rankTeams(String[] votes) {
        int ticketLen = votes[0].length();
        ArrayList<Team> l = new ArrayList<>();
        HashMap<Character, Team> map = new HashMap<>();

        for (String s : votes) {
            for (int i = 0; i < ticketLen; i++) {
                char ch = s.charAt(i);
                Team t = map.get(ch);
                if (t == null) {
                    t = new Team(ticketLen, ch);
                    l.add(t);
                    map.put(ch, t);
                }

                t.addTicket(i);
            }
        }

        Collections.sort(l);

        StringBuilder sb = new StringBuilder();
        for (Team t : l) {
            sb.append(t.getFlag());
        }

        return sb.toString();
    }

    class Team implements Comparable<Team> {

        private int[] tickets;
        private char flag;

        public Team(int len, char flag) {
            this.tickets = new int[len];
            this.flag = flag;
        }

        public void addTicket(int rank) {
            tickets[rank]++;
        }

        public int[] getTickets() {
            return tickets;
        }

        public int getTicket(int idx) {
            return tickets[idx];
        }

        public char getFlag() {
            return flag;
        }

        @Override
        public int compareTo(Team t) {
            for (int i = 0; i < tickets.length; i++) {
                int tmp = t.getTicket(i);
                if (tickets[i] != tmp) {
                    return tmp - tickets[i];
                }
            }

            return this.flag - t.flag;
        }
    }
}
