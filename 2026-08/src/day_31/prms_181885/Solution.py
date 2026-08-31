def solution(todo_list, finished):
    return [todo for todo, done in zip(todo_list, finished) if not done]
