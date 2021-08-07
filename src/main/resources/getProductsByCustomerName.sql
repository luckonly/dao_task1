SELECT orders.product_name
FROM netology.customers customers
         LEFT JOIN netology.orders orders
                   ON customers.id = orders.customer_id
WHERE lower(customers.name) = lower(:name)