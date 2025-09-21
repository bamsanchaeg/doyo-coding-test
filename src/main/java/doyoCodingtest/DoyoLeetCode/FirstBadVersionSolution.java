package doyoCodingtest.DoyoLeetCode;

class VersionControl {
    private int bad;

    // 생성자에서 첫 불량 버전(bad)을 지정
    public VersionControl(int bad) {
        this.bad = bad;
    }

    // 주어진 버전이 불량인지 확인하는 API
    public boolean isBadVersion(int version) {
        return version >= bad;
    }
}

public class FirstBadVersionSolution extends VersionControl {

    public FirstBadVersionSolution(int bad) {
        super(bad);
    }

    // 첫 불량 버전을 찾는 메서드 (Binary Search)
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // overflow 방지
            if (isBadVersion(mid)) {
                right = mid; // 불량이면 왼쪽으로 이동
            } else {
                left = mid + 1; // 양품이면 오른쪽으로 이동
            }
        }

        return left; // left == right가 되는 순간이 첫 불량 버전
    }

    // 실행 테스트
    public static void main(String[] args) {
        // 테스트 케이스 1
        int n1 = 5, bad1 = 4;
        FirstBadVersionSolution s1 = new FirstBadVersionSolution(bad1);
        System.out.println("첫 불량 버전: " + s1.firstBadVersion(n1)); // 출력: 4

        // 테스트 케이스 2
        int n2 = 1, bad2 = 1;
        FirstBadVersionSolution s2 = new FirstBadVersionSolution(bad2);
        System.out.println("첫 불량 버전: " + s2.firstBadVersion(n2)); // 출력: 1

        // 테스트 케이스 3
        int n3 = 10, bad3 = 7;
        FirstBadVersionSolution s3 = new FirstBadVersionSolution(bad3);
        System.out.println("첫 불량 버전: " + s3.firstBadVersion(n3)); // 출력: 7
    }
}
