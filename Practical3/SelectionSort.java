// In this code selection Sort is implemented 
import java.util.*;
class SelectionSort
{
    public static void selectionSort(int nums[])
    {
        for(int i=0;i<nums.length;i++)
        {
            int minIdx=i;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]>nums[j])
                {
                    minIdx=j;
                }
            }
            int temp=nums[minIdx];
            nums[minIdx]=nums[i];
            nums[i]=temp;
        }
    }

    public static void printArray(int nums[])
    {
        for(int i:nums)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        Scanner sn=new Scanner(System.in);

        System.out.print("\nEnter the Size of Array : ");
        int size=sn.nextInt();

        int nums[]=new int[size];
        System.out.print("\nEnter the elements of Array : ");
        for(int i=0;i<size;i++)
        {
            nums[i]=sn.nextInt();
        }

        System.out.print("\nOriginal Array : ");
        printArray(nums);

        selectionSort(nums);

        System.out.print("\nSorted Array : ");
        printArray(nums);
    }

}