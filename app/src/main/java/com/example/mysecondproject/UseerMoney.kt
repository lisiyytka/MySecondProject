package com.example.mysecondproject

class Field{
    val id: Int = 0
    var Category: String = " "
    var Loss: Int = 0
    var Income: Int = 0
    var Date: String = " "
    var Comment: String = " "

    constructor(Category: String,
                Loss: Int,
                Income: Int,
                Date: String,
                Comment: String,){
        this.Category = Category
        this.Comment = Comment
        this.Date = Date
        this.Income = Income
        this.Loss = Loss
    }
}