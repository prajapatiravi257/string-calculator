package planetnoobs.stringcalculator;

public class StringCalculator {

    protected int calculateString(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        try {
            String[] list = input.split(Constants.DELIMITER);

            int total = 0;
            for(String item: list) {
                int num = Integer.parseInt(item);
                if(num < 0) {
                    return -1;
                }
                total += num;
            }

            if(total> 1000) {
                total -= 1000;
            }

            return total;
        }catch(Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
}
