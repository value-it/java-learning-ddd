# java-learning-ddd

## リファクタリングネタ
- SQLインジェクションを防ぐ
  - Datasource実装をMyBatisに切り替える
- TodoListクラスを作る
  - 総件数、緊急件数のカウントはTodoListクラスの関心事にする
- タイトル、説明のバリデーションを実装する
  - 必須、文字数、文字種
- ValueObjectを作る
- すべてのクラスをイミュータブルにする
- @ModelAttribute を使う
- 緊急フラグの画面表現を改善する
- TODOを編集可能にする
- TODOを削除可能にする