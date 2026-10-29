Informations the data types

# Entities

**Clients**
- clientId
- name
- email

---

**Items**
- itemId
- name
- description
- unitPrice

---

**OrderItems**
- orderItemsId
- **orderId (FK)** 
- **itemId (FK)**
- quantity
- unitPriceAtPurchase

---

**Orders**
- orderId
- **clientId (FK)**
- totalValue
- status
- createdAt


