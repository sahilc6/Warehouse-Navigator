export default function ItemList({ items }) {
  return (
    <ul className="p-4">
      {items.map((item, idx) => (
        <li key={idx} className="border-b py-2">{item.name}</li>
      ))}
    </ul>
  );
}
