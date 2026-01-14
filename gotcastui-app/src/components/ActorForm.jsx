import { useState, useEffect } from "react";
import { createActor, updateActor } from "../services/actorService";

function ActorForm({ selectedActor, onSuccess }) {
  const [actor, setActor] = useState({
    name: "",
    age: "",
    gender: ""
  });

  useEffect(() => {
    if (selectedActor) {
      setActor(selectedActor);
    }
  }, [selectedActor]);

  const handleChange = (e) => {
    setActor({
      ...actor,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (actor.id) {
        await updateActor(actor.id, actor);
        alert("Actor updated successfully!");
      } else {
        await createActor(actor);
        alert("Actor created successfully!");
      }
      setActor({ name: "", age: ""});
      onSuccess();
    } catch (error) {
      console.error(error);
      alert("Error saving actor");
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: "20px" }}>
      <h2>{actor.id ? "Update Actor" : "Create Actor"}</h2>
      <div>
        <label>Name:</label>
        <input name="name" value={actor.name} onChange={handleChange} required />
      </div>
      <div>
        <label>Age:</label>
        <input type="number" name="age" value={actor.age} onChange={handleChange} required />
      </div>
      <div>
      </div>
      <button type="submit">{actor.id ? "Update" : "Create"}</button>
    </form>
  );
}

export default ActorForm;
