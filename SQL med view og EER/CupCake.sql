SELECT o.userID, email, pass, o.orderID, oc.orderID, oc.orderedcakeID, quantity, subtotal, 
t.caketopID,t.cakename,t.price, b.cakename, b.price,  b.cakebotID 	FROM users u 
inner join orders o on u.userID = o.userID
inner join orderscupcakes oc on o.orderID =  oc.orderID 
inner join cupcaketop t on oc.caketopID = t.caketopID
inner join cupcakebot b on oc.cakebotID = b.cakebotID;