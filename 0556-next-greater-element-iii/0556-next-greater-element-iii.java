class Solution {
    public int nextGreaterElement(int n) {
        if (n < 10) {
            return -1;
        }
        String num = String.valueOf(n);
        int len = num.length();
        char[] ch = num.toCharArray();
        if (good(ch)) {
            if (ch[0] >= ch[len - 1]) {
                return -1;
            }
        }

        Stack<Integer> st = new Stack<>();
        int index = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                if (ch[st.peek()] > ch[i]) {
                    do {
                        index = st.pop();
                    } while (!st.isEmpty() && ch[st.peek()] > ch[i]);
                } else {
                    st.push(i);
                }
            }
            if (index != -1) {
                char temp = ch[i];
                ch[i] = ch[index];
                ch[index] = temp;
                rev(ch, i + 1, ch.length - 1);
                break;
            }
        }

        long ans = Long.parseLong(new String(ch));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;

    }

    private void rev(char[] arr, int s, int e) {
        int len = e - s + 1;
        for (int i = 0; i < len / 2; i++) {
            char temp = arr[s + i];
            arr[s + i] = arr[e - i];
            arr[e - i] = temp;
        }
    }

    private boolean good(char[] c) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < c.length - 1; i++) {
            if (c[i + 1] > c[i]) {
                dec = false;
            }
            if (c[i + 1] < c[i]) {
                inc = false;
            }
        }
        return inc || dec;
    }
}
