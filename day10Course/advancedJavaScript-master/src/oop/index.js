class Customer {
    constructor(id,customerNumber){
        this.id = id
        this.customerNumber = customerNumber
    }
}

let customer = new Customer(1,"12345");
//prototyping
customer.name = "Murat Kurtboğan"
console.log(customer.id)

Customer.bisey = "Bişey"
console.log(Customer.bisey)

console.log(customer.customerNumber)


class IndividualCustomer extends Customer{
    constructor(firstName, id,customerNumber){
        super(id,customerNumber)
        this.firstName = firstName
    }
}

class CorporateCustomer extends Customer{
    constructor(companyName, id,customerNumber){
        super(id, customerNumber)
        this.companyName = companyName
    }
}



let products = [
    {id:1, name : "Acer Laptop", unitPrice:15000},
    {id:2, name : "Asus Laptop", unitPrice:16000},
    {id:3, name : "Hp Laptop", unitPrice:13000},
    {id:4, name : "Dell Laptop", unitPrice:12000},
    {id:5, name : "Casper Laptop", unitPrice:17000},
]

console.log("<ul>")
products.map(product=>console.log(`<li>${product.name}</li>`))
console.log("</ul>")