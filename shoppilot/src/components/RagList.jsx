import { useEffect, useState } from "react";
import api from "../api/api";

export default function RagList() {
  const [rags, setRags] = useState([]);

  useEffect(() => {
    api.get("/api/rags").then((res) => setRags(res.data));
  }, []);

  return (
    <div className="p-4">
      <h2 className="font-bold mb-2">Racks (Rags)</h2>
      <ul>
        {rags.map(r => (
          <li key={r.id}>{r.name} (Position: {r.position})</li>
        ))}
      </ul>
    </div>
  );
}
