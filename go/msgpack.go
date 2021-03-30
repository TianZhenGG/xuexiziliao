package main

import (
	"fmt"

	"github.com/vmihailenco/msgpack"
)

type Person struct {
	Name   string
	Age    int
	Gender string
}

func main() {
	p1 := Person{
		Name:   "tianzhen",
		Age:    18,
		Gender: "nan",
	}
	b, err := msgpack.Marshal(p1)
	if err != nil {
		fmt.Printf("msgpack marshal failed,err:%v", err)
	return
	}
	var p2 Person
	err = msgpack.Unmarshal(b,&p2)
	if err != nil{
		fmt.Printf("msgapck unmarshal failed,err:%v",err)
		return
	}
	fmt.Printf("p2:%v\n",p2)
}
