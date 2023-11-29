    /**
     * Create a new, reversed list.
     *
     * Examples:
     *
     * * reverse(makeList(1, 2, 3)) should be equivalent to makeList(3, 2, 1)
     *
     * @param list The list to reverse.
     * @return A new list that is reversed of the argument.
     */
    public static ListNode reverse(ListNode list) {
        
        if(list == null){
            return null;
        }

        if(list.next == null){
            return list;
        }

        ListNode nextElement = list.next;

        list.next = null;

        ListNode reverseIt = reverse(nextElement);

        nextElement.next = list;

        return reverseIt;

    }

    /**
     * Get the first n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * headList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(1, 2)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The head list of the specified size.
     */
    public static ListNode headList(ListNode list, int n) {
        
        return headListHelp(list,  n, new ListNode(), 0);
        
    }

    private static ListNode headListHelp(ListNode list, int n, ListNode newList, int index){
        if(n == 0 || index == list.size()){
            return newList;
        }
        newList.add(newList.get(index));
        return headListHelp(list, n-1, newList, index+1);
    }

    /**
     * Get the last n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * tailList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(3, 4)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The tail list of the specified size.
     */
    public static ListNode tailList(ListNode list, int n) {
        return tailListHelp(list, n, new ListNode(), 0);
    }

    private static ListNode tailListHelp(ListNode list, int n, ListNode newList, int index){

        int size = list.size();

        if (n == 0 || index == size){
            ListNode reverseNewList = list.reverse();
            return newList;
        }

        newList.add(list.get(size-1-index));
        return tailListHelp(list, n-1, index+1);


    }
