public class Text {

    static String input = "最も苦手なこと\n" +
            "\n" +
            "特徴 ●自分のアイディアを出し、周囲を動機づけ、達成する ●未来志向 ●社交性に富む\n" +
            "特徴を示す\n" +
            "キーワード\n" +
            "●楽観的 ●創造的 ●人と関わり、人を楽しませる ●感情表現が豊かである ●情熱がある\n" +
            "●人を励まし、モチベーションを高める ●人からの承認を求める ●気まぐれでまとまりがない ●意\n" +
            "思決定が衝動的である\n" +
            "強み ●楽観的 ●独創的 ●夢想家 ●迅速\n" +
            "弱み ●短慮的 ●独善的 ●非現実的 ●短気\n" +
            "意欲的になること ●賞賛、承認される ●創造的な仕事\n" +
            "最も苦手なこと ●無視・拒絶される ●複雑で細かい仕事 ●仲間がいない\n" +
            "口癖 ●すごくいい！ ●誰が言っていたのか？ ●誰が一緒？\n" +
            "力を発揮する状態 ●楽しく、居心地が良い ●コントロールされず、自由さがあ";

    public static void main(String args[]) {

        String[] arr = input.split("●");
        for(String s : arr) {
            System.out.println(s);
        }

    }


}
