// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val AllProducts = customers.flatMap { it.orders }.flatMap { it.products }
    return customers.fold(AllProducts, {
        products, customer ->
        // filter only product which was ordered by each customer
        products.filter { customer.orders.flatMap { it.products }.contains(it) }
    }).toSet()
}
