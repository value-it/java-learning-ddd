# java-learning-ddd

## 動作環境

### 要Java17
https://aws.amazon.com/jp/corretto/

---

## アプリ起動手順
### サンプルTODOアプリ
```shell
./tools/scripts/run-webapp-todo-example
```

---

## リファクタリングネタ
- SQLインジェクションを防ぐ
  - Datasource実装をMyBatisに切り替える
- TodoListクラスを作る
  - 総件数、緊急件数のカウントはTodoListクラスの関心事にする
- タイトル、説明、優先度のバリデーションを実装する
  - 必須、文字数、文字種
- ValueObjectを作る
- Todoクラスをイミュータブルにする
- Controllerで@ModelAttribute を使う
- 緊急フラグの画面表現を改善する
- TODOを編集可能にする
- TODOを削除可能にする
- DONEを実装する