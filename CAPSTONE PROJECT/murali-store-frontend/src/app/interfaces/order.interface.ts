export interface Order {
  id?: number;
  userId: number;
  status: string;
  createdAt?: string;
}

export interface OrderItem {
  id?: number;
  orderId: number;
  productId: number;
  quantity: number;
  priceAtOrder: number;
  productName?: string;
  productImage?: string;
}

export interface OrderDetails {
  order: Order;
  items: OrderItem[];
  totalAmount: number;
}
