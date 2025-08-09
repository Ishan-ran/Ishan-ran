    public class SkillfulSaturday {
        public static void main(String[] args) {
            int[] numbers = {
                1, 3, 5, 2, 6, 7, 3, 4, 8, 9,
                0, 6, 2, 1, 5, 8, 7, 4, 3, 9,
                6, 5, 3, 2, 1, 7, 8, 9, 2, 4,
                6, 1, 0, 3, 5, 7, 8, 4, 2, 9
            };

            int totalElements = numbers.length;
            int windowSize = 5;

            System.out.println("Maximum values in each group of size " + windowSize + ":");

            for (int i = 0; i <= totalElements - windowSize; i++) {
                int currentMax = numbers[i];
                for (int j = 1; j < windowSize; j++) {
                    if (numbers[i + j] > currentMax) {
                        currentMax = numbers[i + j];
                    }
                }
                System.out.print(currentMax + " ");
            }
        }
    }
