public class keySynthesizer {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void main(String[] args) {

        synthesizer.GuitarString string[] = new synthesizer.GuitarString[37];
        for (int i = 0; i < keyboard.length(); i += 1) {
            string[i] = new synthesizer.GuitarString(440 * Math.pow(2, (i - 24) / 12));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                for (int i = 0; i < keyboard.length(); i += 1) {
                    if (key == keyboard.charAt(i)) {
                        string[i].pluck();
                    }
                }
            }
            double sample = 0;
            for (int i = 0; i < keyboard.length(); i += 1) {
                sample += string[i].sample();
            }
            StdAudio.play(sample);
            for (int i = 0; i < keyboard.length(); i += 1) {
                string[i].tic();
            }
        }
    }
}
