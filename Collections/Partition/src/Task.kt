// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> =
        customers.filter {
            val (deliveredOrders, undeliveredOrders) = it.orders.partition { it.isDelivered }
            deliveredOrders.count() < undeliveredOrders.count()
        }.toSet()