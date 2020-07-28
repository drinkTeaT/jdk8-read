package demo;

public class Demo1 {
    public static void main(String[] args) {
        long id = 1234567890;
        String url = idtourl(id);
        System.out.println(url);
        System.out.println(urltoid(url));
    }
    /**
     * id转url
     *
     * @param id
     * @return
     */
    public static String idtourl(Long id) {
        if (id == null) {
            return "";
        }
        return 1 + Long.toString(id * 2 + 56, 36);
    }

    public static long urltoid(String url) {
        return (Long.parseLong(url.substring(1), 36) - 56) / 2;
    }
}
