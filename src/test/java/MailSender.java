import org.junit.Assert;
import org.junit.Test;


public class MailSender {
    @Test
    public void generateUniqueCodeShouldReturnSizeSix() {
        String code = "";

        int size = 6;
        for (int i = 0; i < 6; i++) {
            code += (char) (65 + (int) Math.random() * 92);
        }
        Assert.assertEquals(6,code.length());
    }

}
