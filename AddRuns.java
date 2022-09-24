package Cricket_Score;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddRuns {
    boolean win = false;

    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void addRunTeamOne(MatchDetails matchDetails, Bowler bowler) {
        if (matchDetails.getTotRun() != 0) {
            Set<Map.Entry<Integer, String>> group1Set = matchDetails.group1.entrySet();
            System.out.println("===========================>>  " + matchDetails.team1.toUpperCase() + "  <<===========================");
            System.out.print(" ==========================================");
            System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20, "NAME") + " | ");
            System.out.print("\n ==========================================");
            for (Map.Entry<Integer, String> map : group1Set) {
                System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20, map.getValue()) + " |");
            }
            System.out.print("\n ==========================================");
            System.out.println();

            System.out.println("Batting     :  " + matchDetails.getTeam1());
            // System.out.println(matchDetails.getTeam1() + " is bating...");
            int balls = matchDetails.getMatchFormat() * 6;
            boolean tf = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamOneRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamOneRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            Scanner scanner1 = new Scanner(System.in);
            int db = 1;
            System.out.println("Target      :  " + matchDetails.teamTwoRun.get(0).teamTotalRun);
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner1.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamTwoBowler.put(bowlerName, new Bowler());
                bowler.teamTwoBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    bowler.teamTwoBowler.get(bowlerName).setBalls(1);
                    if (matchDetails.teamOneRun.get(0).teamTotalRun <= matchDetails.teamTwoRun.get(0).teamTotalRun) {
                        String teamRun = scanner1.nextLine();
                        if (teamRun.equals("W")) {
                            bowler.teamTwoBowler.get(bowlerName).setWicker(1);
                            if (tf) {
                                playerOne = no;
                                no++;
                            } else {
                                playerTwo = no;
                                no++;
                            }
                        } else if (teamRun.equals(".")) {
                            matchDetails.teamOneRun.get(0).setDatBal(db);
                        } else {
                            int intRun1 = Integer.parseInt(teamRun);
                            bowler.teamTwoBowler.get(bowlerName).setRun(intRun1);
                            matchDetails.teamOneRun.get(0).setTeamTotalRun(intRun1);
                            matchDetails.setTotRun(intRun1);
                            if (tf) {
                                int intRun = Integer.parseInt(teamRun);
                                matchDetails.teamOneRun.get(playerOne).setRuns(intRun);
                                if (intRun % 2 == 0) {
                                    if (intRun == 4) {
                                        matchDetails.teamOneRun.get(playerOne).setFour(db);
                                    } else if (intRun == 6) {
                                        matchDetails.teamOneRun.get(playerOne).setSix(db);
                                    }
                                } else if (intRun == 1 || intRun == 3) {
                                    tf = false;
                                }
                            } else {
                                int intRun = Integer.parseInt(teamRun);
                                matchDetails.teamOneRun.get(playerTwo).setRuns(intRun);
                                if (intRun % 2 == 0) {
                                    if (intRun == 4) {
                                        matchDetails.teamOneRun.get(playerTwo).setFour(db);
                                    } else if (intRun == 6) {
                                        matchDetails.teamOneRun.get(playerTwo).setSix(db);
                                    }
                                } else if (intRun == 1 || intRun == 3) {
                                    tf = true;
                                }
                            }
                        }

                    } else {
                        int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                        System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
                        win = true;
                        break;
                    }
                }
                if (tf) {
                    tf = false;
                } else {
                    tf = true;
                }
            }

            if (matchDetails.teamOneRun.get(0).teamTotalRun > matchDetails.teamTwoRun.get(0).teamTotalRun) {
                if (!win) {
                    int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
                }
            } else if (!win) {
                int run1 = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                System.out.println(matchDetails.getTeam2() + " won by " + run1 + " runs");
            }
            if (matchDetails.teamOneRun.get(0).teamTotalRun == matchDetails.teamTwoRun.get(0).teamTotalRun) {
                System.out.println("Runs        :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
                System.out.println("Match draw");
            }
        } else {

            int balls = matchDetails.matchFormat * 6;
            boolean tf = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamOneRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamOneRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            //   System.out.println(balls + " Balls");
            Scanner scanner1 = new Scanner(System.in);
            int db = 1;
            int ball = 0;
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner1.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamTwoBowler.put(bowlerName, new Bowler());
                bowler.teamTwoBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    ball++;
                    bowler.teamTwoBowler.get(bowlerName).setBalls(1);
                    String teamRun = scanner1.nextLine();
                    if (teamRun.equals("W")) {
                        bowler.teamTwoBowler.get(bowlerName).setWicker(1);
                        if (tf) {
                            playerOne = no;
                            no++;
                        } else {
                            playerTwo = no;
                            no++;
                        }
                    } else if (teamRun.equals(".")) {
                        matchDetails.teamOneRun.get(0).setDatBal(db);
                    } else {
                        int intRun1 = Integer.parseInt(teamRun);
                        matchDetails.teamOneRun.get(0).setTeamTotalRun(intRun1);
                        matchDetails.setTotRun(intRun1);
                        bowler.teamTwoBowler.get(bowlerName).setRun(intRun1);
                        if (tf) {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamOneRun.get(playerOne).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamOneRun.get(playerOne).setFour(db);
                                } else if (intRun == 6) {
                                    matchDetails.teamOneRun.get(playerOne).setSix(db);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                tf = false;
                            }
                        } else {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamOneRun.get(playerTwo).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamOneRun.get(playerTwo).setFour(db);
                                } else if (intRun == 6) {
                                    matchDetails.teamOneRun.get(playerTwo).setSix(db);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                tf = true;
                            }
                        }
                    }
                }
                if (tf) {
                    tf = false;
                } else {
                    tf = true;
                }
            }
            addRunTeamTwo(matchDetails, bowler);
        }

    }

    public void addRunTeamTwo(MatchDetails matchDetails, Bowler bowler) {
        if (matchDetails.getTotRun() == 0) {

            int balls = matchDetails.getMatchFormat() * 6;
            boolean tf = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamTwoRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamTwoRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            Scanner scanner1 = new Scanner(System.in);
            int db = 1;
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner1.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamOneBowler.put(bowlerName, new Bowler());
                bowler.teamOneBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    bowler.teamOneBowler.get(bowlerName).setBalls(1);
                    String teamRun = scanner1.nextLine();
                    if (teamRun.equals("W")) {
                        bowler.teamOneBowler.get(bowlerName).setWicker(1);
                        if (tf) {
                            playerOne = no;
                            no++;
                        } else {
                            playerTwo = no;
                            no++;
                        }
                    } else if (teamRun.equals(".")) {
                        matchDetails.teamTwoRun.get(0).setDatBal(db);
                    } else {
                        int intRun1 = Integer.parseInt(teamRun);
                        matchDetails.teamTwoRun.get(0).setTeamTotalRun(intRun1);
                        matchDetails.setTotRun(intRun1);
                        bowler.teamOneBowler.get(bowlerName).setRun(intRun1);
                        if (tf) {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamTwoRun.get(playerOne).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamTwoRun.get(playerOne).setFour(db);
                                } else if (intRun == 6) {
                                    matchDetails.teamTwoRun.get(playerOne).setSix(db);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                tf = false;
                            }
                        } else {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamTwoRun.get(playerTwo).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamTwoRun.get(playerTwo).setFour(db);
                                } else if (intRun == 6) {
                                    matchDetails.teamTwoRun.get(playerTwo).setSix(db);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                tf = true;
                            }
                        }
                    }
                }
            }
            if (tf) {
                tf = false;
            } else {
                tf = true;
            }
            addRunTeamOne(matchDetails, bowler);
        } else {

            System.out.println("===========================>>  " + matchDetails.team2.toUpperCase() + "  <<===========================");
            System.out.print(" ==========================================");
            System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20, "NAME") + " | ");
            System.out.print("\n ==========================================");
            Set<Map.Entry<Integer, String>> group2Set = matchDetails.group2.entrySet();
            for (Map.Entry<Integer, String> map : group2Set) {
                System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20, map.getValue()) + " |");
            }
            System.out.print("\n ==========================================");
            System.out.println();

            System.out.println("Batting     :  " + matchDetails.getTeam2());
            int balls = matchDetails.matchFormat * 6;
            boolean tf = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamTwoRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamTwoRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            // System.out.println(balls + " Balls");
            Scanner scanner1 = new Scanner(System.in);
            int db = 1;
            System.out.println("Target      :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner1.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamOneBowler.put(bowlerName, new Bowler());
                bowler.teamOneBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    bowler.teamOneBowler.get(bowlerName).setBalls(1);
                    if (matchDetails.teamOneRun.get(0).teamTotalRun >= matchDetails.teamTwoRun.get(0).teamTotalRun) {
                        String teamRun = scanner1.nextLine();
                        if (teamRun.equals("W")) {
                            bowler.teamOneBowler.get(bowlerName).setWicker(1);
                            if (tf) {
                                playerOne = no;
                                no++;
                            } else {
                                playerTwo = no;
                                no++;
                            }
                        } else if (teamRun.equals(".")) {
                            matchDetails.teamTwoRun.get(0).setDatBal(db);
                        } else {
                            int intRun1 = Integer.parseInt(teamRun);
                            matchDetails.teamTwoRun.get(0).setTeamTotalRun(intRun1);
                            matchDetails.setTotRun(intRun1);
                            bowler.teamOneBowler.get(bowlerName).setRun(intRun1);
                            if (tf) {
                                int intRun = Integer.parseInt(teamRun);
                                matchDetails.teamTwoRun.get(playerOne).setRuns(intRun);
                                if (intRun % 2 == 0) {
                                    if (intRun == 4) {
                                        matchDetails.teamTwoRun.get(playerOne).setFour(db);
                                    } else if (intRun == 6) {
                                        matchDetails.teamTwoRun.get(playerOne).setSix(db);
                                    }
                                } else if (intRun == 1 || intRun == 3) {
                                    tf = false;
                                }
                            } else {
                                int intRun = Integer.parseInt(teamRun);
                                matchDetails.teamTwoRun.get(playerTwo).setRuns(intRun);
                                if (intRun % 2 == 0) {
                                    if (intRun == 4) {
                                        matchDetails.teamTwoRun.get(playerTwo).setFour(db);
                                    } else if (intRun == 6) {
                                        matchDetails.teamTwoRun.get(playerTwo).setSix(db);
                                    }
                                } else if (intRun == 1 || intRun == 3) {
                                    tf = true;
                                }
                            }
                        }
                    } else {
                        int run = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                        System.out.println(matchDetails.getTeam2() + " won by " + run + " runs");
                        win = true;
                        break;
                    }
                }
                if (tf) {
                    tf = false;
                } else {
                    tf = true;
                }
            }
            if (matchDetails.teamOneRun.get(0).teamTotalRun < matchDetails.teamTwoRun.get(0).teamTotalRun) {
                if (!win) {
                    int run = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam2() + " won by " + run + " runs");
                }
            } else if (!win) {
                int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
            }
            if (matchDetails.teamOneRun.get(0).teamTotalRun == matchDetails.teamTwoRun.get(0).teamTotalRun) {
                System.out.println("Runs        :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
                System.out.println("Match draw");
            }
        }
    }
}
