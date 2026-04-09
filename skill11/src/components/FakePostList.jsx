import React, { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {

  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [userId, setUserId] = useState("");

  const fetchPosts = () => {
    setLoading(true);
    axios.get("https://dummyjson.com/posts")
      .then((res) => {
        setPosts(res.data.posts);
        setLoading(false);
      })
      .catch(() => {
        setLoading(false);
      });
  };

  useEffect(() => {
    fetchPosts();
  }, []);

  return (
    <div>
      <h2>Fake API Posts</h2>

      <button onClick={fetchPosts}>Refresh</button>

      <br /><br />

      <select onChange={(e) => setUserId(e.target.value)}>
        <option value="">All</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
        <option value="4">User 4</option>
        <option value="5">User 5</option>
      </select>

      <br /><br />

      {loading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {posts
            .filter((post) => userId === "" || post.userId == userId)
            .map((post) => (
              <li key={post.id}>
                <b>{post.title}</b><br />
                {post.body}
              </li>
            ))}
        </ul>
      )}
    </div>
  );
}

export default FakePostList;