package cinema
//data class SomeObj(var seatspur: Int = 0,var currincome: Int= 0)
fun helper2(rows:Int,seats:Int,newlist:MutableList<MutableList<Char>>,arr: Array<Int>){
        println("Enter a row number:")
        val rowno=readln().toInt()
        println("Enter a seat number in that row:")
        val seatno=readln().toInt()
        if(rowno>rows || seatno>seats){
            println("Wrong input!")
            helper2(rows,seats,newlist,arr)
        }
        else if(newlist[rowno-1][seatno-1]=='B'){
            println("That ticket has already been purchased!")
            helper2(rows,seats,newlist,arr)
        }
        else{
            newlist[rowno-1][seatno-1]='B'
            arr[0]++
            if(rows*seats<=60){
              println("Ticket price: $10")
              arr[1]+=10
            }
            else{
              if(rowno<=(rows/2)){
                println("Ticket price: $10")
                arr[1]+=10
             }
             else{
               println("Ticket price: $8")
               arr[1]+=8
            }
        }
    }
}
fun helper(rows:Int,seats:Int,newlist:MutableList<MutableList<Char>>,arr: Array<Int>){
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")
    val ent=readln().toInt()
    if(ent==1){
        println("Cinema:")
        print(" ")
        for(i in 1..(seats-1)){
            print("${i} ")
        }
        println("${seats}")
        for(i in 1..rows){
            print("$i ")
            for(j in 1..(seats-1)){
                print("${newlist[i-1][j-1]} ")
            }
            println("${newlist[i-1][seats-1]}")
        }
        helper(rows,seats,newlist,arr)
    }
    if(ent==2){
        helper2(rows,seats,newlist,arr)
        helper(rows,seats,newlist,arr)
    }
    if(ent==3){
        println("Number of purchased tickets: ${arr[0]}")
        var totalseat=rows*seats
        var perc=(arr[0].toDouble()/totalseat)*100
        val formatPercentage = "%.2f".format(perc)
        println("Percentage: ${formatPercentage}%")
        println("Current income: $${arr[1]}")
        var totalinc=0
        if(rows*seats<=60){
            totalinc=rows*seats*10
        }
        else{
            var toprows=(rows/2)
            var topinc=(toprows)*seats*10
            var botinc=(rows-(rows/2))*seats*8
            totalinc=topinc+botinc
        }
        println("Total income: $${totalinc}")
        helper(rows,seats,newlist,arr)
    }
    if(ent==0){
        return
    }
}

fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rows=readln().toInt()
    println("Enter the number of seats in each row:")
    val seats=readln().toInt()
    val newlist:MutableList<MutableList<Char>> = mutableListOf()
    for(i in 1..rows){
        val clist=mutableListOf<Char>()
        for(i in 1..seats){
            clist.add('S')
        }
        newlist.add(clist)
    }
    var seatspur=0
    var currincome=0
    val arr=arrayOf(seatspur,currincome)
    helper(rows,seats,newlist,arr)
    
    
    
           
    
}
