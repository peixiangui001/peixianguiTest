import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    // int a = 0;
    // String b = "12";
    // public static void main(String[] args) {
    //     String str = "北京市(朝阳区)(西城区)(海淀区)";
    //     Pattern p = Pattern.compile(".*?(?=\\()");
    //     Matcher m = p.matcher(str);
    //     if(m.find())
    //     System.out.println(m.group());
    //
    // }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};

        List<List<Integer>> list = solution.permute(nums);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).size()+"  ");
            }
            System.out.println();
        }
        System.out.println(list.size());

    }


}

class Solution {
    static List<List<Integer>> list ;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        f(nums,nums.length,list1,0);
        return list;
    }
    public void f(int[] nums,int len,List<Integer> list1,int index){
        if(index==len){
            list.add(list1);
            return;
        }
        for (int i = 0; i <=list1.size() ; i++) {
            list1.add(i,nums[index]);
            index++;
            f(nums,len,list1,index);
            list1.remove(i);
        }
    }
}

