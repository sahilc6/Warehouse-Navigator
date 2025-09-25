import { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";   // ✅ to read state from AddList
import api from "../api/api";
import "./RagMap.css";

export default function RagMap() {
  const location = useLocation();
  const preSelectedItems = location.state?.items || []; // ✅ items from AddList

  const [rags, setRags] = useState([]);
  const [items, setItems] = useState(preSelectedItems.join(", ")); // prefill box
  const [path, setPath] = useState([]);
  const [highlightIndex, setHighlightIndex] = useState(-1);

  // Load rags on mount
  useEffect(() => {
    api.get("/api/rags").then(res => {
      const ordered = [...res.data].sort((a, b) => a.position - b.position);
      setRags(ordered);
    });
  }, []);

  // If items were passed from AddList, auto-fetch path after rags load
  useEffect(() => {
    if (preSelectedItems.length > 0 && rags.length > 0) {
      fetchPath(preSelectedItems);
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [rags]);

  const fetchPath = async (itemList) => {
    if (!itemList || itemList.length === 0) return;
    const { data } = await api.post("/api/path", itemList);
    setPath(data.shortestPath || []);
    setHighlightIndex(-1);
    animatePath(data.shortestPath || []);
  };

  const findPath = async () => {
    const list = items.split(",").map(i => i.trim()).filter(Boolean);
    fetchPath(list);
  };

  // animate through path array
  const animatePath = (pathArr) => {
    let i = 0;
    const timer = setInterval(() => {
      setHighlightIndex(i);
      i++;
      if (i >= pathArr.length) clearInterval(timer);
    }, 600);
  };

  return (
    <div className="map-container">
      <h1 className="title">Rack Map Pathfinder</h1>

      {/* Manual input (still available) */}
      <div className="input-row">
        <input
          type="text"
          className="item-input"
          placeholder="Enter items (comma separated)"
          value={items}
          onChange={e => setItems(e.target.value)}
        />
        <button className="find-btn" onClick={findPath}>Find Path</button>
      </div>

      {/* Grid of racks */}
      <div className="rack-grid">
        {rags.map((rag) => {
          const inPath = path.includes(rag.name);
          const current =
            highlightIndex !== -1 && path[highlightIndex] === rag.name;
          return (
            <div
              key={rag.id}
              className={`rack ${inPath ? "in-path" : ""} ${current ? "current" : ""}`}
            >
              {rag.name}
            </div>
          );
        })}
      </div>
    </div>
  );
}
