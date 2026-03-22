import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  const [students, setStudents] = useState([
    { id: 1, name: "Bhavi", course: "CSE" },
    { id: 2, name: "Nani", course: "ECE" },
    { id: 3, name: "Indra", course: "IT" },
    { id: 4, name: "Love", course: "MECH" },
    { id: 5, name: "Care", course: "CIVIL" }
  ]);

  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

const addStudent = () => {

  if (!newStudent.id || !newStudent.name || !newStudent.course) {
    alert("Please fill all fields");
    return;
  }

  setStudents([...students, newStudent]);

  setNewStudent({
    id: "",
    name: "",
    course: ""
  });
};
const deleteStudent = (id) => {
  const filtered = students.filter((student) => student.id !== id);
  setStudents(filtered);
};

  return (
  <div className="container">
    <h2>Student Manager</h2>

    <input
      type="number"
      placeholder="ID"
      value={newStudent.id}
      onChange={(e) =>
        setNewStudent({ ...newStudent, id: e.target.value })
      }
    />

    <input
      type="text"
      placeholder="Name"
      value={newStudent.name}
      onChange={(e) =>
        setNewStudent({ ...newStudent, name: e.target.value })
      }
    />

    <input
      type="text"
      placeholder="Course"
      value={newStudent.course}
      onChange={(e) =>
        setNewStudent({ ...newStudent, course: e.target.value })
      }
    />

    <button onClick={addStudent}>Add Student</button>

    {students.length === 0 ? (
      <p>No students available</p>
    ) : (
      <table border="1" style={{ marginTop: "20px" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Course</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.course}</td>
              <td>
                <button onClick={() => deleteStudent(student.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    )}
  </div>
);
}

export default StudentManager;