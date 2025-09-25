import { useState } from "react";
import api from "../api/api";

export default function PathFinder() {
  const [items, setItems] = useState("");
  const [path, setPath] = useState([]);

  const findPath = async () => {
    const list = items.split(",").map(i => i.trim());
    const { data } = await api.post("/api/path", list);
    setPath(data.shortestPath || []);
  };

  return (
    <div className="p-4">
      <h2 className="font-bold mb-2">Find Shortest Path</h2>
      <input
        className="border p-2 w-full"
        placeholder="Enter items comma-separated"
        value={items}
        onChange={(e) => setItems(e.target.value)}
      />
      <button
        className="mt-2 bg-green-500 text-white px-4 py-2"
        onClick={findPath}
      >
        Find Path
      </button>
      {path.length > 0 && (
        <p className="mt-4">Shortest Path: {path.join(" → ")}</p>
      )}
    </div>
  );
}
