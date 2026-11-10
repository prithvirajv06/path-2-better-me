public class MoveZeroToLast {

    /**
     * Name of the technique: Snowball Method
     * 
     * 
     * Easy Tamil explination:
     * ஒரு array-ல உள்ள எல்லா 0-களையும் கடைசிக்கு தள்ளணும். மற்ற எண்கள் அவங்க பழைய
     * வரிசையிலேயே இருக்கணும். புது array உருவாக்கக் கூடாது.
     * 
     * உதாரணம்: [0, 1, 0, 3, 12] → [1, 3, 12, 0, 0]
     * 
     * “Snowball” யோசனை
     * 
     * ஒரு பனிப்பந்து (snowball) மலையிலிருந்து உருண்டு வரும்போது, போகும் வழியில உள்ள
     * பனியை சேர்த்துக்கிட்டே பெருசாகும்.
     * 
     * இங்கே 0-கள்தான் அந்த பனிப்பந்து. நாம array-ல இடமிருந்து வலமா போகும்போது:
     * 
     * 0 பார்த்தா → பனிப்பந்துல சேர்த்துக்கோ. அதாவது snowballSize ஒன்று கூடும்.
     * 0 இல்லாத எண் பார்த்தா → அந்த எண்ணை பனிப்பந்துக்கு முன்னாடி தூக்கிப் போடு,
     * அதன் இடத்துல 0 வைத்துவிடு. இதனால பனிப்பந்து ஒரு அடி முன்னே நகர்ந்த மாதிரி
     * ஆகும்.
     */
    public void moveZeroes(int[] nums) {
        int snowballSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                snowballSize++;
            else if (snowballSize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowballSize] = temp;
            }
        }
    }
}
