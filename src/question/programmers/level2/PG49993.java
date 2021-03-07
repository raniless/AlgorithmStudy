package question.programmers.level2;

//  스킬트리
public class PG49993 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        PG49993 pg49993 = new PG49993();
        int answer = pg49993.solution(skill, skill_trees);
        System.out.println(answer);
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees) {
            if(isMatched(skill, skill_tree)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isMatched(String skill, String skill_tree) {
        int preOrder = 0;   // 선행으로 배워야할 스킬 순서

        for(char targetSkill : skill_tree.toCharArray()) {
            int skillOrder = skill.indexOf(targetSkill);

            //선행배움이 필요한 스킬
            if(skillOrder > -1) {
                //선행학습 조건에 충족하지 않으면 해당 스킬트리는 불가
                if(skillOrder != preOrder) {
                    return false;
                }

                preOrder++;
            }
        }

        return true;
    }
}