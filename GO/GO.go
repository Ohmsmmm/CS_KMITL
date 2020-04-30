package main
import (
	"bufio"
	"fmt"
	"math/big"
	"crypto/rand"
	"os"
	"sort"
	"strconv"
)

func main() {
	id := getStdId()
	num := randNum()
	sort.Ints(num)
	fmt.Println(num)
	searchId(id[6:8], num)
}

func getStdId() string{
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter your student id: ")
	id, _ := reader.ReadString('\n')
	return id
}

func randNum() []int {
	var num []int
	min := int64(10)
	max := int64(99)
	for i:=1; i<1000; i++ {
		nBig, err := rand.Int(rand.Reader, big.NewInt(max-min+1))
		if err != nil {
			panic(err)
		}
		n := nBig.Int64() + min
		num = append(num, int(n))
	}
	return num
}

func searchId(id string, num []int){
	var count int
	var status string
	last2Pos , _:= strconv.Atoi(id)
	fmt.Printf("last 2 position student id: %d \n", last2Pos)
	for i:=0; i<len(num); i++{
		if num[i] == last2Pos {
			count++
		}
		if num[i] > last2Pos {
			break
		}
	}
	if count > 3 {
		status = "A"
		fmt.Printf("amount: %d \nstatus: %s \n", count, status)
	} else if count != 0 {
		fmt.Printf("amount: %d \n", count)
	} else {
		status = "F"
		fmt.Printf("status: %s \n", status)
	}
}