/**
 * Crashing Balloon
 * Time Limit: 2 Seconds Memory Limit: 65536 KB
 * 
 * On every June 1st, the Children's Day, there will be a game named
 * "crashing balloon" on TV. The rule is very simple. On the ground there are
 * 100 labeled balloons, with the numbers 1 to 100. After the referee shouts
 * "Let's go!" the two players, who each starts with a score of "1", race to
 * crash the balloons by their feet and, at the same time, multiply their scores
 * by the numbers written on the balloons they crash. After a minute, the little
 * audiences are allowed to take the remaining balloons away, and each
 * contestant reports his\her score, the product of the numbers on the balloons
 * he\she's crashed. The unofficial winner is the player who announced the
 * highest score.
 * 
 * Inevitably, though, disputes arise, and so the official winner is not
 * determined until the disputes are resolved. The player who claims the lower
 * score is entitled to challenge his\her opponent's score. The player with the
 * lower score is presumed to have told the truth, because if he\she were to lie
 * about his\her score, he\she would surely come up with a bigger better lie.
 * The challenge is upheld if the player with the higher score has a score that
 * cannot be achieved with balloons not crashed by the challenging player. So,
 * if the challenge is successful, the player claiming the lower score wins.
 * 
 * So, for example, if one player claims 343 points and the other claims 49,
 * then clearly the first player is lying; the only way to score 343 is by
 * crashing balloons labeled 7 and 49, and the only way to score 49 is by
 * crashing a balloon labeled 49. Since each of two scores requires crashing the
 * balloon labeled 49, the one claiming 343 points is presumed to be lying.
 * 
 * On the other hand, if one player claims 162 points and the other claims 81,
 * it is possible for both to be telling the truth (e.g. one crashes balloons 2,
 * 3 and 27, while the other crashes balloon 81), so the challenge would not be
 * upheld.
 * 
 * By the way, if the challenger made a mistake on calculating his/her score,
 * then the challenge would not be upheld. For example, if one player claims
 * 10001 points and the other claims 10003, then clearly none of them are
 * telling the truth. In this case, the challenge would not be upheld.
 * 
 * Unfortunately, anyone who is willing to referee a game of crashing balloon is
 * likely to get over-excited in the hot atmosphere that he\she could not
 * reasonably be expected to perform the intricate calculations that refereeing
 * requires. Hence the need for you, sober programmer, to provide a software
 * solution.
 * 
 * Input
 * 
 * Pairs of unequal, positive numbers, with each pair on a single line, that are
 * claimed scores from a game of crashing balloon.
 * Output
 * 
 * Numbers, one to a line, that are the winning scores, assuming that the player
 * with the lower score always challenges the outcome.
 * Sample Input
 * 
 * 343 49
 * 3599 610
 * 62 36
 * 
 * Sample Output
 * 
 * 49
 * 610
 * 62
 * 
 * @author jasonleakey
 * 
 */
package edu.algorithm.acm.zoj1003;