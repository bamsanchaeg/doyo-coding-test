package DoyoLeetCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class TwoSum {

    //그냥 N개의 target 수 만큼 배열 생성하는데 문제에서는 4개 이하로 나옴.
    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // ArrayList 생성
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i< N; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }

        // ArrayList를 배열로 변환
        int[] numsArray = nums.stream().mapToInt(i -> i).toArray();

       bw.write(Arrays.toString(twoSum(numsArray, N)) + "\n");
       bw.flush();
       bw.close();
       br.close();

    }


    public static int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];

        for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }

        }

        return output;

    }
}
