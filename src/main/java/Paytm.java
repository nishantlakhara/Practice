/**
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output: false
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * cats (andog) -> dog(an) -> an() -> false
 *              -> sand() -> false
 * dog (catsan) -> sand() -> false
 *
 * O(2 pow n) -> O(n^2)
 *
 * appleandapple -> apple (pen) -> pen() -> true;
 * catsanddog -> cat (sandog) -> og() -> false
 *               cats (andog) -> og() -> false
 *               catsa -> false
 *
 * "cat, cats" -> "cats, cat"
 *
 * input: arr[] = {“apple”, “app”, “biscuit”, “mouse”, “orange”, “bat”, “microphone”, “mine”},
 * Queries[] = {{a, e}, {a, p}} Output: apple app
 *
 * Trie    a -> p -> p(t) -> l -> e(t)
 *
 *
 *
 */

public class Paytm {

}
